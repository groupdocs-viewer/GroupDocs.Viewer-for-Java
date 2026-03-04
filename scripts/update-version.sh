#!/usr/bin/env bash
#
# Updates GroupDocs.Viewer version across all projects, Dockerfiles, and README.
#
# Usage:
#   ./scripts/update-version.sh 26.1
#   ./scripts/update-version.sh          # prints current version

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "$0")/.." && pwd)"

POMS=(
  Examples/pom.xml
  Demos/Spring/pom.xml
  Demos/Dropwizard/pom.xml
)

GRADLES=(
  Demos/Javalin/build.gradle.kts
  Demos/Ktor/build.gradle.kts
  Demos/Micronaut/build.gradle.kts
  Demos/Compose/build.gradle.kts
)

DOCKERFILES=(
  Demos/Spring/docker/Dockerfile-openjdk8-bullseye
  Demos/Spring/docker/Dockerfile-openjdk11-bullseye
  Demos/Spring/docker/Dockerfile-openjdk18-bullseye
  Demos/Dropwizard/docker/Dockerfile-openjdk8-bullseye
  Demos/Dropwizard/docker/Dockerfile-openjdk11-bullseye
  Demos/Dropwizard/docker/Dockerfile-openjdk18-bullseye
)

print_current_version() {
  echo "Current versions:"
  echo ""
  echo "  pom.xml:"
  for pom in "${POMS[@]}"; do
    ver=$(grep -m1 -oP '(?<=<version>)[0-9]+\.[0-9]+(?=</version>)' "${REPO_ROOT}/${pom}" || echo "?")
    printf "    %-40s %s\n" "${pom}" "${ver}"
  done
  echo ""
  echo "  build.gradle.kts:"
  for gradle in "${GRADLES[@]}"; do
    ver=$(grep -oP '(?<=^version = ")[0-9]+\.[0-9]+(?=")' "${REPO_ROOT}/${gradle}" || echo "?")
    printf "    %-40s %s\n" "${gradle}" "${ver}"
  done
  echo ""
  echo "  Dockerfiles:"
  for df in "${DOCKERFILES[@]}"; do
    ver=$(grep -oP '(?<=LABEL version=")[0-9]+\.[0-9]+(?=")' "${REPO_ROOT}/${df}" || echo "?")
    printf "    %-40s %s\n" "${df}" "${ver}"
  done
  echo ""
  echo "  README.md:"
  grep -n '| [0-9]\+\.[0-9]\+ |$' "${REPO_ROOT}/README.md" | head -1 | sed 's/^/    /'
}

update_version() {
  local VERSION="$1"

  echo "Updating all versions to ${VERSION}..."
  echo ""

  # Maven pom.xml — replace first <version>XX.YY</version> (the project version).
  # The groupdocs-viewer dependency uses ${project.version} so it follows automatically.
  for pom in "${POMS[@]}"; do
    sed -i "0,/<version>[0-9]\+\.[0-9]\+<\/version>/s/<version>[0-9]\+\.[0-9]\+<\/version>/<version>${VERSION}<\/version>/" "${REPO_ROOT}/${pom}"
    echo "  ${pom}"
  done

  # Gradle build files — version = "XX.YY"
  # The groupdocs-viewer dependency uses $version so it follows automatically.
  for gradle in "${GRADLES[@]}"; do
    sed -i "s/^version = \"[0-9]\+\.[0-9]\+\"/version = \"${VERSION}\"/" "${REPO_ROOT}/${gradle}"
    echo "  ${gradle}"
  done

  # Dockerfiles — LABEL version="XX.YY"
  for df in "${DOCKERFILES[@]}"; do
    sed -i "s/LABEL version=\"[0-9]\+\.[0-9]\+\"/LABEL version=\"${VERSION}\"/" "${REPO_ROOT}/${df}"
    echo "  ${df}"
  done

  # README.md — demo table last column and Maven dependency snippet
  sed -i "s/| [0-9]\+\.[0-9]\+ |$/| ${VERSION} |/" "${REPO_ROOT}/README.md"
  sed -i "s/<version>[0-9]\+\.[0-9]\+<\/version>/<version>${VERSION}<\/version>/" "${REPO_ROOT}/README.md"
  echo "  README.md"

  echo ""
  echo "Done. Verify with: $0"
}

if [[ $# -eq 0 ]]; then
  print_current_version
elif [[ $# -eq 1 ]]; then
  if ! [[ "$1" =~ ^[0-9]+\.[0-9]+$ ]]; then
    echo "Error: version must match pattern XX.YY (e.g. 25.12)" >&2
    exit 1
  fi
  update_version "$1"
else
  echo "Usage: $0 [version]" >&2
  echo "  No arguments  — print current versions" >&2
  echo "  version        — update all versions (e.g. $0 26.1)" >&2
  exit 1
fi
