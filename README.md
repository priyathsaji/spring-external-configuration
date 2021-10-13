# spring-external-configuration

Configuration of a spring boot applicaton can be externalised using cloud config server and cloud config client


## Cloud Config Server

```
	<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-config-server</artifactId>
		</dependency>
```

- cloud config server can connect to git, svn or file system to get the configuration files
- config file should of format ` <<project name>>.properties`
- git repository for cloud config can be specified using 
    `spring.cloud.config.server.git.uri=<<git url>>`

## Cloud Config Client

```
	<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-config</artifactId>
		</dependency>
```
- spring boot app with this dependency can conect to remote config server to fetch configuration
- cloud config server to connect can be configured using
    `spring.config.import=optional:configserver:<<config server url>>`
- application name can be specified using 
    `spring.application.name=<<project name>>`
- inorder to update the configuration **without restarting the server**
    - need to use acutuator depenedency 
        ```
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
        ```
    - anotate the components that have to be refreshed by `@RefreshScope` anotation
    - call an empty **POST** request to `http://<<url>>/acutator/refresh`
