#! /bin/sh

javac -classpath lib/postgresql-42.2.18.jar: Program.java -d ./build

java -classpath lib/postgresql-42.2.18.jar:./build/: Program

rm ./build/ -rf