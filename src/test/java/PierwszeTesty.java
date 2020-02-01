import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PierwszeTesty {


    private WebDriver driver;

    // @Before tag mówiący nam o tym, że wszystko
    // w metodzie setUp musi być wykonane przed uruchomieniem testu. Zanim uruchomimy test, uruchamia się Befor, później test a na końcu After

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    // @After uruchamia się zawsze po zakończeniu testu, połączony z tearDown, uruchamia sie nawet jeśli test nie przejdzie
    @After
    public void tearDown() {
        //quit = zamknij przeglądarke
        driver.quit();
    }

    //jest to tag który mówi nam, że metoda testCase1 jest metodą testową
    @Ignore
    @Test
    public void testCase1() {
        // metoda get otwiera adres internetowy
        driver.get("https://www.google.com/");
        //metoda sendKeys wpisuje tekst do jakiegoś pola
        driver.findElement(By.name("q")).sendKeys("test");
    }

    @Ignore
    @Test
    public void logowanieDoFacebooka() throws InterruptedException {
        //krok 1 otwieramy strone
        driver.get("https://www.facebook.com");
        //krok 2 w okienko adres e-mail wpisujemy e-maila
        //1. znajdź okienko 2. wpisz tekst
        WebElement email =driver.findElement(By.id("email"));
        email.sendKeys("test");
        //Thread.sleep
        Thread.sleep(5000);
        //krok 3 w okienku hasło wpisujemy hasło
        WebElement password =driver.findElement(By.id("pass"));
        password.sendKeys("test");
        Thread.sleep(5000);
        //krok 4 kliknij zaloguj się
        //1. znajdź element 2. kliknij na niego
        WebElement zaloguj= driver.findElement(By.id("u_0_b"));
        zaloguj.click();
        Thread.sleep(5000);
    }
//zadania dla testera
    @Ignore
    @Test
    public void logowanie(){

        //krok 1 otwieramy stronę
        driver.get("http://zadaniadlatestera.pl/textBox.html");
        //krok 2 wpisujemy login
        WebElement login = driver.findElement(By.id("login"));
        login.sendKeys("testLogin");
        //krok 3wpisujemy hasło
        WebElement password = driver.findElement(By.id("password"));
        login.sendKeys("testPassword");
        //krok 4 klikamy przycisk prześlij
        WebElement przeslij = driver.findElement(By.id("sendLogin"));
        przeslij.click();
    }

    @Ignore
    @Test
    public void rejestracja(){
        //otworz strone
        driver.get("http://zadaniadlatestera.pl/textBox.html");
        //wypelnij imie
        WebElement imie = driver.findElement(By.id("name"));
        imie.sendKeys("Karolina");
        //wypelnij nazwisko
        WebElement nazwisko = driver.findElement(By.id("surname"));
        nazwisko.sendKeys("TestNazwisko");
        //wypelnij pesel
        WebElement pesel = driver.findElement(By.id("personalId"));
        pesel.sendKeys("12345667676666");
        //wypelnij nr telefonu
        WebElement telefon = driver.findElement(By.name("phoneNumber"));
        telefon.sendKeys("222333444");
        //kliknij wyslij zapytanie
        WebElement wyslij = driver.findElement(By.name("send"));
        wyslij.click();
    }

    @Ignore
    @Test
    public void ankieta() {
        //otwieramy strone
        driver.get("http://zadaniadlatestera.pl/radioButton.html");
        //wybierz plec
        WebElement kobieta= driver.findElement(By.id("woman"));
        kobieta.click();
        //wybierz wiek
        WebElement wiek=driver.findElement(By.id("age2"));
        wiek.click();
        //wybierz wyksztalcenie
        WebElement edu=driver.findElement(By.id("level2"));
        edu.click();
        //wybierz miejsce zamieszkania
        WebElement miasto=driver.findElement(By.id("city"));
        miasto.click();
        //czy lubisz swoja prace
        WebElement nie=driver.findElement(By.id("no"));
        nie.click();
        //wyslij zapytanie
    }
    @Ignore
    @Test
    public void Checkboxy() {
        driver.get("http://zadaniadlatestera.pl/checkbox.html");
        WebElement gry=driver.findElement(By.id("games"));
        gry.click();
        WebElement spiewanie=driver.findElement(By.id("singing"));
        gry.click();
        WebElement czytanie=driver.findElement(By.id("reading"));
        gry.click();
    }

    //wybieramy z listy np dropdown
    @Ignore
    @Test
    public void select() throws InterruptedException {
        driver.get("http://zadaniadlatestera.pl/select.html");
        //selecta uzywamy przy drop down listach
        Select gatunek = new Select(driver.findElement(By.name("sort")));
        //wybierz z listy 'Hymn'
        gatunek.selectByValue("Hymn");
        Thread.sleep(3000);
        Select wiek = new Select(driver.findElement(By.name("age")));
        //1 bo druga opcja w tablicy - dla doroslych, by index poprzez miejsce w tablicy
        wiek.selectByIndex(1);
        Thread.sleep(3000);
        Select regal = new Select(driver.findElement(By.name("place")));
        //metoda visible text
        regal.selectByVisibleText("VI");
        regal.selectByIndex(0);
        regal.selectByValue("vii");
        Thread.sleep(3000);
        //odznaczanie wszystkiego !!!uwaga przy dropdown list nie dziala deselect
        regal.deselectAll();
        //wpisz numer porzadkowy i zaznaczyli piotr mikus
        WebElement number = driver.findElement(By.id("index"));
        number.sendKeys("24");
        Thread.sleep(3000);
        Select osoba = new Select(driver.findElement(By.name("personName")));
        osoba.selectByIndex(3);
        Thread.sleep(3000);
        //kliknij wyslij
        WebElement wyslij = driver.findElement(By.id("send"));
        wyslij.click();
    }

    //alerty
    @Ignore
    @Test
    public void alert (){
        driver.get("http://zadaniadlatestera.pl/alert1.html");
        WebElement decyzja = driver.findElement(By.id("dec"));
        decyzja.click();
        Alert alert =driver.switchTo().alert();
        //klikamy OK
        //alert.accept();
        //klikamy anuluj
        alert.dismiss();
    }

        @Test
        public void alert2() throws InterruptedException {
            driver.get("http://zadaniadlatestera.pl/alert2.html");
        //wpisz index do textboxa
        WebElement tekst=driver.findElement(By.id("index"));
        tekst.sendKeys("456");
            Thread.sleep(3000);
        // kliknij skasuj
        WebElement skasuj=driver.findElement(By.id("delete"));
        skasuj.click();
            Thread.sleep(3000);
        // zaakceptuj alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
            Thread.sleep(3000);
        }

}


