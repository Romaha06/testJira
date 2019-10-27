#testJira





#Что необходимо для того что бы запустить данный тест.

1. jdk - Java SE Development Kit 8.
   
    Ссылка для скачивания - https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

2. Среда разработки, лучше всего intellij idea.    
   
    Ссылка для скачивания - https://www.jetbrains.com/idea/download
    
 После того как вы установили на ваш ПК Java и intellij idea:
 
 1.Скачать данный репозиторий с GitHub
 
 2.Запустить проект в IntelliJ Idea с помощью Maven

 3.Проверить что подключились все необходимые библиотеки
 
 Если библиотеки не подключилсь то необходимо:
 
 В фале pom.xml прописать dependency, после чего Maven сам скачает их и установит
 
##### Selenium dependency:
  
           <dependency>
               <groupId>org.seleniumhq.selenium</groupId>
               <artifactId>selenium-java</artifactId>
               <version>3.141.59</version>
           </dependency>
 
##### TestTNG dependency:
 
         <dependency>
             <groupId>org.testng</groupId>
             <artifactId>testng</artifactId>
             <version>6.14.3</version>
         </dependency>
    
    
##### Webdrivermanager dependency:
 
         <dependency>
             <groupId>io.github.bonigarcia</groupId>
             <artifactId>webdrivermanager</artifactId>
             <version>3.7.1</version>
             <scope>compile</scope>
         </dependency>
         
 4.Запустить тест. 
 
 
   **Алгоритм для подключения Allure**
   
 1.Обновить pom.xml
  
##### Allure-testng dependency

         <dependency>
             <groupId>io.qameta.allure</groupId>
             <artifactId>allure-testng</artifactId>
             <version>2.12.0</version>
         </dependency>   
         
         
##### Добавить properties
             <properties>
                 <aspectj.version>1.8.10</aspectj.version>
                 <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
             </properties>     
      
##### Добавить plugins
         <build>
             <plugins>
                 <plugin>
                     <groupId>org.apache.maven.plugins</groupId>
                     <artifactId>maven-compiler-plugin</artifactId>
                     <configuration>
                         <source>1.8</source>
                         <target>1.8</target>
                     </configuration>
                 </plugin>
                 <plugin>
                     <groupId>org.apache.maven.plugins</groupId>
                     <artifactId>maven-surefire-plugin</artifactId>
                     <version>2.20</version>
                     <configuration>
                         <suiteXmlFiles>
                             <suiteXmlFile>TestNG.xml</suiteXmlFile>
                         </suiteXmlFiles>
                         <argLine>
                             -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
                         </argLine>
                     </configuration>
                     <dependencies>
                         <dependency>
                             <groupId>org.aspectj</groupId>
                             <artifactId>aspectjweaver</artifactId>
                             <version>${aspectj.version}</version>
                         </dependency>
                     </dependencies>
                 </plugin>
             </plugins>
         </build>                                
             
##### Добавить TestNG.xml в корень проекта (что бы явно указать какие тесты и как запускать, не параллельно)
             <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
             <suite name="Parallel test suite" >
                 <test name="Issue">
                     <classes>
                         <class name="JIRATest"/>
                     </classes>
                 </test>
             </suite>
             
##### Обновить тест - добавить @Feature

2.Установить Allure CLI
           
            https://docs.qameta.io/allure/#_installing_a_commandline
           
3.Запустить тест

_mvn clean test_

4.Выполнить в корне проекта консольную команду Allure generate --clean и получить отчет

Отчет будет в корне проекта в папке "allure-report"

В помощь - https://www.swtestacademy.com/allure-testng/


**Как добавить группу @smoke, @regression?**


1.Определить группы в TestNG.xml

        <groups>
            <run>
              <include name="Regression"/>
              <exclude name="SKIP"/>
            </run>
        </groups>
        
2.Добавить группу в тест

    @Test(groups = {"Regression", "SKIP"})
    
3.Добавить группу в @BeforeTest @AfterTest

    @BeforeTest(groups = "Regression")
