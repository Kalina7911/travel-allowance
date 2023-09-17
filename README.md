## travel-allowance 

### Imię i nazwisko: Alina Kotnarowska

### Nazwa projektu: Travel Allowance
<br>

### *Opis*
<br>

Projek służy do obliczania wysokości dodatku do popołudniowej zmiany zwanego Travel Allowance. 

Jest przeznaczona dla pracowników międzynarodowej firmy, gdzie obowiązuje komunikacja w języku 

angielskim, dlatego wszystkie instrukcje w aplikacji są wyłącznie w tym języku.
<br>
<br>
<br>

Aplikacja składa się z 3 widoków: **Travel Allowance**, **Preferences** i **Rate of Allowance**.
<br>
<br>
*  Widok **Travel Allowance** wyświetla informacje nt. dodatku zwanego Travel Allowance. 

*  Widok **Preferences** służy do wprowadzania przez użytkownika 2 informacji/preferencji:
     1.  w jakie dni chce pracować w następnym miesiącu
     2.  czy chce danego dnia pracować na zmianę poranną AM czy popołudniową PM.

   Informacje te zapisywane są w bazie danych i służą do obliczania wysokości dodatku za popołudniową \
   zmianę czyli Travel Allowance.
   
*   Widok  **Rate of Allowance** wyświetla 2 informacje dla danego użytkowika :
      1.  wysokość dodatku do popołudniowych zmian/Travel Allowance w danym miesiącu
      2.  liczba dni na popołudniową zmianę/ PM danego miesiąca
   <br>
   <br>
  
### *Wprowadzanie danych na stronie Preferences*
<br>

Na stronie Preferences znajdują się 3 pola do wprowadzania danych: **Select Date**, **Select Shift**, **Enter Your Index**.
<br>
<br>
1.  Po kliknięciu na pole **Select Date** pokazuje się kalendarz z nieaktywnym bieżącym miesiącem.

    Należy kliknąć na strzałkę w górnym, prawym rogu, żeby przejsć do kolejnego miesiąca.
 
     *Aktywny jest zawsze tylko kolejny miesiąc, ponieważ aplikacja służy do wpisywania preferencji użytkownika*
 
      *(to znaczy wybranych dni pracy i zmnian: poranna AM lub popołudniowa PM) tylko na kolejny miesiąc* 


2.   Użytkownik zaznacza 1 dzień , w którym chce pracować w następnym miesiącu.

     *Praca odbywa się w systemie 24/7, więc każdy dzień może być wybrany łącznie z sobotami i niedzielami.*

3.  Następnie użytkownik przechodzi do pola **Select Shift** i wybiera albo zmianę poranną czyli AM, albo zmianę popołudniową czyli PM.
   
4.  Następnie użytkownik przechodzi do pola **Enter Your Index** i wpisuje swój Index

     *Index to unikatowy numer użytkownika w bazie danych. Za pomocą tego numeru (Index) użytkownik jest identyfikowany.*

     *Każdy użytkownik musi znać swój index, żeby zachować zaznaczone preferencje (dzień i zmiana) i wyświetlić*

     *informacje nt. Travel Allowance na stronie Rate of Allowance.*

      *Obecnie w bazie danych (tabela "users") jest 3 użytkowników do testowania aplikacji z następującymi indeksami (Index): 111, 112, 113,*

       *Wybrany index (111, 112 lub 113) należy wpisać w polu **Enter Your Index**.*
   
    
5.  Następny krok to zachowanie wybranych danych poprzez naciśnięcie przycisku **SAVE**
   <br>

   **Użytkownik powtarza kroki od 1 do 5 tyle razy, ile jest dni pracujących w danym miesiącu.**

   **Aplikacja informuje, ile dni pozostało do wprowadzenia w danym miesiącu, wyświetlając komunikat:**
   
   **Missing working days..** 
   
<br>
   Jeżeli pola Sekect Date, Select Shift , Enter Your Index zostały poprawnie zaznaczone, aplikacja wyświetla 2 informacje:

  1.    wybór został zapisany: **Preference Added**
  2.    ile jeszcze dni należy wybrać, np. **Missing working days 20**, co oznacza ,że użytkownik musi jeszcze wybrać/dodać 20 dni.


        *Każdy miesiąc ma inną liczbę dni pracujących (working days). Liczba dni pracujących dla każdego miesiąca jest ustawiona**

         *w tabeli "months".*

Pozostałe komunikaty dla użytkowanika wyświetlane na stronie Preferences: 

1.  **You have marked all the required working days** : informuje użytkownika , że wymagana liczba dni pracujących na następny miesiąc

     została zaznaczona i zachowana w bazie danych.

2.  **Too many working days. Your last choices will not be recoreded**: ta informacja pojawia się, jeżeli użytkownik zaznaczy za dużo

      dni pracujących na następny miesiąc.
    <br>
    <br>
    <br>
    
### *Wyświetlanie danych na stronie Rate of Allowance*
<br>

Strona Rate of Allowance służy do wyświetlania 2 informacji: 

1.  wysokość dodatku zwanego Travel Allowance dla danego użytkownika,
2.  ilość popołudniowych zmian przepracowanych przez pracownika w wybranym miesiącu.
<br>

Na stronie Rate of Allowance znajdują się 2 pola: **Enter Your Index**, **Select Month**. 

1. W polu **Enter Your Index** użytkownik wpisuje swój Index (numer), pod którym widnieje w bazie danych.

   *Informacje odnośnie tego ,co to jest Index, do czego służy i o dostępnych aktualnie indeksach do testowania*

   *w bazie danych znajdują się w punkcie 4 w częsci: Wprowadzanie danych na stronie Preferences.*
   
3.  Następnie w polu **Select Month** użytkownik wybiera miesiąc.

4.  Następnie użytkownika klika w przycisk **Calculate**.

Po wykonaniu powyższych kroków, aplikacja wyświeltla 2 informacje: 

1.  informację, ile użytkownik otwrzyma PLN w ramach dodatku za pracę na popołudniowe zmiany w wybranym miesiącu

     (Travel Allowance). Informacja wyświetlana jest w wierszu: **Your Travel Allowance**. 

2.  informację o ilości zmian popołudniowych w wybranym miesiącu. Ta informacja jest wyświetlana w wierszu:

     **Number of PM Shifts**. 
   
 
<br>

### *Zainicjalizowane dane wyjściowe*
<br>

1. uzupełniona tabela Months: 12 miesięcy + liczba dni pracujących dla każdego miesiąca


![image](https://github.com/Kalina7911/travel-allowance/assets/115398298/cb02ed1f-ce4c-4452-a5a3-e6afd4e6a9a2)

2. tabela Users uzupełniona 3 użytkownikami z indeksami 111, 112, 113

![image](https://github.com/Kalina7911/travel-allowance/assets/115398298/84f980bf-660b-417d-a85d-e411bb652046)




### *Stos technologiczny*:
- Java
- Maven
- Spring Boot(Web,JPA)
- PostgreSQL
- Thymeleaf
- Railway.app
- HTML
- CSS
- Pikaday.js
- Moment.js

### *Uruchomienie*
Proszę przejść na link https://travel-allowance.up.railway.app/


