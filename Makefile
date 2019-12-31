VERSION = $(lastword $(subst ",, $(shell grep defproject project.clj)))

default: all

all: lint test build
	@lein build

#############################################################################
###   Protobuf Support   ####################################################
#############################################################################

PROTOBUF_SRC = src/proto
PROTOBUF_GO = src/golang/api
PROTOBUF_JAVA = src/java/
GRADLE_GRPC_DIR = $(PROTOBUF_JAVA)/main
GRADLE_JAVA_DIR = $(GRADLE_GRPC_DIR)/java
GRADLE_BUILD_DIR = ./build

# export GOPATH=~/go
# export GOBIN=~/go/bin
# export PATH=$PATH:$GOBIN

go-deps:
	@GO111MODULE=off go get github.com/golang/protobuf/protoc-gen-go
	@GO111MODULE=off go install github.com/golang/protobuf/protoc-gen-go

java-deps:
	@brew install gradle
	@gradle wrapper --gradle-version 6.0.1

protoc-gen: protoc-gen-go protoc-gen-java

protoc-gen-go: go-deps $(PROTOBUF_GO)/*.pb.go
protoc-gen-java: java-deps
	@./gradlew build
	@mv $(GRADLE_GRPC_DIR)/hxgm30 $(PROTOBUF_JAVA)
	@cp -r $(GRADLE_JAVA_DIR)/* $(PROTOBUF_JAVA)
	@rm -rf $(GRADLE_GRPC_DIR) $(PROTOBUF_JAVA)/test $(GRADLE_BUILD_DIR)

$(PROTOBUF_GO)/%.pb.go: $(PROTOBUF_SRC)/%.proto
	@protoc -I $(PROTOBUF_SRC) --go_out=plugins=grpc:$(PROTOBUF_GO) $<

$(PROTOBUF_JAVA)/%.java: $(PROTOBUF_SRC)/%.proto
	@mkdir -p $(PROTOBUF_JAVA)
	@protoc -I $(PROTOBUF_SRC) \
		--plugin=protoc-gen-grpc-java=~/.m2/repository/io/grpc/protoc-gen-grpc-java/1.26.0 \
		--java_out=$(PROTOBUF_JAVA) $<

clean-protobuf:
	@rm -f $(PROTOBUF_JAVA)/*.java $(PROTOBUF_GO)/*.pb.go

#############################################################################
###   Golang Support   ######################################################
#############################################################################

# export GOPATH=~/go:
# export GOBIN=~/go/bin:
# export PATH=$PATH:$GOBIN:

GO ?= go
GOFMT ?= $(GO)fmt

DEFAULT_GOPATH=$(shell echo $$GOPATH|tr ':' '\n'|awk '!x[$$0]++'|sed '/^$$/d'|head -1)
ifeq ($(DEFAULT_GOPATH),)
DEFAULT_GOPATH := ~/go
endif
DEFAULT_GOBIN=$(DEFAULT_GOPATH)/bin
export PATH:=$(PATH):$(DEFAULT_GOBIN)

GOLANGCI_LINT=$(DEFAULT_GOBIN)/golangci-lint
RICH_GO = $(DEFAULT_GOBIN)/richgo

GODOC=godoc -index -links=true -notes="BUG|TODO|XXX|ISSUE"

build:
	@echo ">> Compiling Go libraries ..."
	@$(GO) build ./...

#############################################################################
###   Golang Custom Installs   ##############################################
#############################################################################

GOLANGCI_LINT = $(DEFAULT_GOBIN)/golangci-lint
RICH_GO = $(DEFAULT_GOBIN)/richgo
GODA = $(DEFAULT_GOBIN)/goda

$(GOLANGCI_LINT):
	@echo ">> Couldn't find $(GOLANGCI_LINT); installing ..."
	curl -sfL https://raw.githubusercontent.com/golangci/golangci-lint/master/install.sh | \
	sh -s -- -b $(DEFAULT_GOBIN) v1.21.0

$(RICH_GO):
	@echo ">> Couldn't find $(RICH_GO); installing ..."
	@GOPATH=$(DEFAULT_GOPATH) \
	GOBIN=$(DEFAULT_GOBIN) \
	GO111MODULE=on \
	$(GO) get -u github.com/kyoh86/richgo

$(GODA):
	@echo ">> Couldn't find $(GODA); installing ..."
	@GOPATH=$(DEFAULT_GOPATH) \
	GOBIN=$(DEFAULT_GOBIN) \
	GO111MODULE=on \
	$(GO) get -u github.com/loov/goda

#############################################################################
###   Golang Linting & Testing   ############################################
#############################################################################

show-linter:
	@echo $(GOLANGCI_LINT)

lint-silent: $(GOLANGCI_LINT)
	@$(GOLANGCI_LINT) \
	--enable=typecheck \
	--enable=golint \
	--enable=gocritic \
	--enable=misspell \
	--enable=nakedret \
	--enable=unparam \
	--enable=lll \
	--enable=goconst \
	--out-format=colored-line-number \
	run ./...

lint:
	@echo '>> Linting source code'
	@GO111MODULE=on $(MAKE) lint-silent

test: $(RICH_GO)
	@echo '>> Running all tests'
	@GO111MODULE=on $(RICH_GO) test ./... -v

test-nocolor:
	@echo '>> Running all tests'
	@GO111MODULE=on $(GO) test ./... -v

#############################################################################
###   Release Process   #####################################################
#############################################################################

version:
	@echo "$(VERSION)"

tag:
	@echo "Tags:"
	@git tag|tail -5
	@git tag "v$(VERSION)"
	@echo "New tag list:"
	@git tag|tail -6

tag-and-push: tag
	@git push --tags

tag-delete: VERSION ?= 0.0.0
tag-delete:
	@git tag --delete v$(VERSION)
	@git push --delete origin v$(VERSION)
