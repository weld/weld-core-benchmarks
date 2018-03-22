#!/bin/bash

VERSIONS="2.2.16.SP1 2.3.5.Final 2.4.6.Final 3.0.2.Final";
BENCHMARKS="";
OUTPUT_PATH="$PWD/target/report"
MVN_CMD="mvn"

while getopts ":v:b:o:m:" opt; do
  case $opt in
    v) VERSIONS="$OPTARG"
    ;;
    b) BENCHMARKS="$OPTARG"
    ;;
    o) OUTPUT_PATH="$OPTARG"
    ;;
    m) MVN_CMD="$OPTARG"
    ;;
    \?) echo "Invalid option -$OPTARG" >&2
    ;;
  esac
done

if [ -n  "$BENCHMARKS" ]; then
    echo "Specific benchmarks to run: $BENCHMARKS"
fi
echo "I'm about to run benchmarks for versions: $VERSIONS";
echo "Using maven command: $MVN_CMD"
$MVN_CMD --version

RESULT_FILES="";
for i in $(echo $VERSIONS)
do
  if [[ "${i}" == "3"* ]];
  then
    # Activate Weld 3 profile
    $MVN_CMD package -Dversion.weld=$i -Pweld3
  else
    $MVN_CMD package -Dversion.weld=$i
  fi
  java -jar target/weld-core-benchmarks.jar -rf json -rff target/results-$i.json $BENCHMARKS
  RESULT_FILES="$RESULT_FILES target/results-$i.json"
done;

echo "Generate report from $RESULT_FILES in $OUTPUT_PATH"
java -cp target/weld-core-benchmarks.jar org.jboss.weld.benchmark.report.ReportGenerator "$RESULT_FILES" $OUTPUT_PATH

