# Автоматизация тестирования веб-приложения с использованием библиотеки REST-assured <img width="50%" title="DemoWebShop" src="images/logo/WebShop_logo.png">

# <a name="Содержание">Содержание:</a>

+ [Используемые технологии](#ИспользуемыеТехнологии)
+ [Реализация проверок](#РеализацияПроверок)
+ [Запуск тестов из Jenkins](#ЗапускТестовИзJenkins)
+ [Оповещение в Telegram](#ОповещениеВTelegram)
+ [Отчет о результатах прохождения тестов в Allure Report](#ОтчетОРезультатахПрохожденияТестовВAllureReport)
+ [Интеграция с Allure TestOps](#ИнтеграцияСAllureTestOps)
    + [Список тестовых случаев в проекте](#СписокТестовыхСлучаевВПроекте)
    + [Dashboards](#Dashboards)
+ [Интеграция с Jira](#ИнтеграцияСJira)


# <a name="ИспользуемыеТехнологии">Используемые технологии</a>

<p align="center">
<img width="6%" title="IntelliJ" src="images/logo/IntelliJ.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="GitHub" src="images/logo/github.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Allure TestOps" src="images/logo/AllureTestOps.svg">
<img width="6%" title="Allure Report" src="images/logo/AllureReport.svg">
<img width="6%" title="Jira Cloud" src="images/logo/Jira.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
</p>

# <a name="РеализацияПроверок">Реализация проверок</a>

> Авторизация пользователя в системе
> 
> Проверка возможности регистрации нового пользователя UI
> 
> Проверка изменения профиля существующего пользователя API+UI


## <a name="ЗапускТестовИзJenkins">Запуск тестов из Jenkins</a>

```bash
clean test
```
# <a name="ОповещениеВTelegram">Оповещение в Telegram</a>

Отправка уведомлений о результатах прохождения тестов осуществляется с помощью Telegram бота.

<p  align="center">
<img src="images/screens/API_Telegram.PNG" alt="TelegramBot" width="600">
</p>


# <a name="ОтчетОРезультатахПрохожденияТестовВAllureReport">Отчет о результатах прохождения тестов в Allure Report</a>


<p  align="center">
<img src="images/screens/APIReport.png" alt="AllureReportApi" width="1050">
</p>

<p  align="center">
<img src="images/screens/AllureReportApi.png" alt="AllureTestCases" width="1050">
</p>

# <a name="ИнтеграцияСAllureTestOps">Интеграция с Allure TestOps</a>

Allure TestOps предоставляет возможность командам создавать тестовую документацию, хранить,
запускать и анализировать ручные и автоматические тесты в одном месте и в режиме реального времени.

## <a name="СписокТестовыхСлучаевВПроекте">Список тестовых случаев в проекте</a>

<p  align="center">
<img src="images/screens/API_testcasesTestOPs.png" alt="AllureTestOpsTestCases" width="1050">
</p>

## <a name="Dashboards">Dashboards</a>

Отслеживание хода выполнения тестирования в Allure TestOps:
<p  align="center">
<img src="images/screens/TestOpsDash_api.PNG" alt="TestOpsDash_api" width="1050">
</p>

# <a name="ИнтеграцияСJira">Интеграция с Jira</a>
Интеграция с Jira позволяет отследить результаты прохождения тестов. 

<p  align="center">
<img src="images/screens/API_Jira.PNG" alt="JiraAPI" width="1050">
</p>