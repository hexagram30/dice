#!/bin/bash

VERSION=$(./resources/scripts/get-version.sh)
BUILDDATE=$(date -u +"%Y-%m-%dT%H:%M:%SZ")
GITCOMMIT=$(./resources/scripts/get-commit-id.sh)
GITBRANCH=$(git rev-parse --abbrev-ref HEAD)
GITSUMMARY=$(git describe --tags --dirty --always)

IN_FILE=resources/templates/version.tmpl.clj
OUT_FILE=src/clj/hxgm30/dice/version.clj

echo "Updating '$OUT_FILE' ..."

cat $IN_FILE | \
        sed -e "s|%%VERSION%%|$VERSION|" \
            -e "s|%%BUILDDATE%%|$BUILDDATE|" \
            -e "s|%%GITCOMMIT%%|$GITCOMMIT|" \
            -e "s|%%GITBRANCH%%|$GITBRANCH|" \
            -e "s|%%GITSUMMARY%%|$GITSUMMARY|" > $OUT_FILE
