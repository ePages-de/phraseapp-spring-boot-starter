#!/bin/bash
set -e # Exit with nonzero exit code if anything fails

echo "TRAVIS_TAG is $TRAVIS_TAG"

if [[ "$TRAVIS_TAG" =~ ^[0-9.]+ ]] ; then
	./gradlew publish
fi