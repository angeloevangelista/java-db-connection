# Como compilar

⚠️ **Se no windows, substitua _:_ por _;_**

Compile com o seguinte comando:

```bash
javac -classpath lib/postgresql-42.2.18.jar: Program.java -d ./build
#                        ↑
#                   driver jdbc
```

Para executar:

```bash
java -classpath lib/postgresql-42.2.18.jar:./build/: Program
#                        ↑
#                   driver jdbc
```
