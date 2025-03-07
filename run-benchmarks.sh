#!/bin/bash

VERSIONS="6.0.0.Final 6.0.1.Final";
BENCHMARKS="";
OUTPUT_PATH="$PWD/target/report"
MVN_CMD="mvn"
JAVA_OPTS=""

while getopts ":v:b:o:m:j:" opt; do
  case $opt in
    v) VERSIONS="$OPTARG"
    ;;
    b) BENCHMARKS="$OPTARG"
    ;;
    o) OUTPUT_PATH="$OPTARG"
    ;;
    m) MVN_CMD="$OPTARG"
    ;;
    j) JAVA_OPTS="$OPTARG"
    ;;
    \?) echo "Invalid option -$OPTARG" >&2
    ;;
  esac
done

if [ -n  "$BENCHMARKS" ]; then
    echo "Specific benchmarks to run: $BENCHMARKS"
fi
echo "I'm about to run benchmarks for versions: $VERSIONS";
echo "Using JVM options: $JAVA_OPTS"
echo "Using maven command: $MVN_CMD"
$MVN_CMD --version

RESULT_FILES="";
for i in $(echo $VERSIONS)
do
  $MVN_CMD package -Dversion.weld=$i
  java $JAVA_OPTS -jar target/weld-core-benchmarks.jar -rf json -rff target/results-$i.json $BENCHMARKS
  RESULT_FILES="$RESULT_FILES target/results-$i.json"
done;

echo "Generate report from $RESULT_FILES in $OUTPUT_PATH"
java -cp target/weld-core-benchmarks.jar org.jboss.weld.benchmark.report.ReportGenerator "$RESULT_FILES" $OUTPUT_PATH

