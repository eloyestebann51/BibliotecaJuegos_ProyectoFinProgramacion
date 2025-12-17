#!/bin/bash

# Carpeta para resultados
mkdir -p test-results

# Archivo XML de reporte JUnit
REPORT_FILE="test-results/results.xml"

# Inicio del XML
echo '<?xml version="1.0" encoding="UTF-8"?>' > $REPORT_FILE
echo '<testsuites>' >> $REPORT_FILE
echo '  <testsuite name="BashSumTest" tests="1" failures="0">' >> $REPORT_FILE

# Test de suma
EXPECTED=6
ACTUAL=$((2 + 3))

if [ "$ACTUAL" -eq "$EXPECTED" ]; then
    echo "Test suma: OK"
else
    echo "Test suma: FAIL"
    # Marcar fallo en el XML
    sed -i 's/failures="0"/failures="1"/' $REPORT_FILE
    exit 1
fi

# Final del XML
echo '    <testcase classname="BashSumTest" name="testSuma"/>' >> $REPORT_FILE
echo '  </testsuite>' >> $REPORT_FILE
echo '</testsuites>' >> $REPORT_FILE

exit 0
