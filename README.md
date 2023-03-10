# itss_linux_project
## Introduction
this is repository that contains source code and release of Hust web of group 1 in ITSS Linux System and Network Management class (135395). The web is used as a demonstration for using pfsense to public a web.

## Run web server in Linux
1. Download demo_hust-0.0.1-SNAPSHOT.jar in [Releases page](https://github.com/thanhnamnguyen/itss_linux_project-/releases/tag/public)
2. This jar file require java jdk version 18. Install with
```
sudo apt install -y openjdk-18-jdk
``` 
3. After that you can check current version by
```
java --version
``` 
4. Run web server by command 
```
java -jar (location)/demo_hust-0.0.1-SNAPSHOT.jar
```
5. Web server will be run in port 8080. Test website using "http://localhost:8080" or "http://"private_ip":8080"
