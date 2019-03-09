#!/bin/bash
echo "Updating ant"
wget --no-check-certificate https://www.apache.org/dist/ant/binaries/apache-ant-1.10.5-bin.tar.gz
tar -xzvf apache-ant-1.10.5-bin.tar.gz
export PATH=`pwd`/apache-ant-1.10.5/bin:$PATH
echo $(ant -version)