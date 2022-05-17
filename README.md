
# Pelican REST API

To read project task:

Pelican/src/main/java/io/gunahusko/pelican/task/TASK.md

---

## Technologies

Java | Spring Boot | Gradle | Mockito test

---

## Introduction

Application is made so, you can add/change/remove countries(change domains).

Do it in >> Pelican/src/main/resources/application.properties 

Add like this:

{pelican-api.domain-}  +  {country_name_in_lover_case} = {domain_address}

--

Example:

If you want to add Latvia:

pelican-api.domain-latvia=http://localhost:8084 

--

Example:

If you want to add Sweden:

pelican-api.domain-sweden=http://localhost:8085

---

## Have to run a project

- Download the project
- Run it in VS Code or IntelliJ
- Run PelicanApplication

---

## To test a project

- You can Download FREE SoapUI Open Source >> https://www.soapui.org/downloads/soapui/
- The project must be running
- Open SoupUI
- File >> New REST project >> Can be called anything
- Right click on project >> New REST MockService >> Can be called anything
- 2 clicks on REST MockService name
- Click on gear symbol >> Change port 8083 >> OK >> Close window
- Right click on REST MockService name >> Add mew mock action >> Choose GET and Enter /translation/hello >> Close window
- Right click on /translation/hello file >> New MockResponse >> Http Status Code: 200 - OK

Enter: 
{
	"translation" : "tere"
}
- Right click on REST MockService name -> Restart
Now Enter in browser http://localhost:8080/country/Estonia/Hello

You will receive:
{
	"data" : "Tere"
}

---


## Authors

- [@gunahusko](https://github.com/gunahusko/Pelican)

