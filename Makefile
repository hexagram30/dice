# export GOPATH=~/go
# export GOBIN=~/go/bin
# export PATH=$PATH:$GOBIN

PROTOBUF_SRC = src/proto
PROTOBUF_GO = src/golang/api
PROTOBUF_JAVA = src/java/
GRADLE_GRPC_DIR = $(PROTOBUF_JAVA)/main
GRADLE_JAVA_DIR = $(GRADLE_GRPC_DIR)/java
GRADLE_BUILD_DIR = ./build

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