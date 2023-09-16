## travel-allowance 

### Imię i nazwisko: Alina Kotnarowska

### Nazwa projektu: Travel Allowance

#### Opis:

Projek służy do obliczania wysokości dodatku do popołudniowej zmiany zwanego Travel Allowance. 

Jest przeznaczona dla pracowników międzynarodowej firmy, gdzie obowiązuje komunikacja w języku 

angielskim, dlatego wszystkie instrukcje w aplikacji są wyłącznie w tym języku. 


Aplikacja składa się z 3 widoków: Travel Allowance, Preferences i Rate of Allowance.

Widok Travel Allowance wyświetla informacje nt. dodatku zwanego Travel Allowance. 


Widok Preferences służy do wprowadzania przez użytkowniaka 2 informacji/preferencji:

1. w jakie dni chce pracować w następnym miesiącu
2. czy chce danego dnia pracować na zmianę poranną AM czy popołudniową PM.

Informacje te zapisywane są w bazie danych i służą do obliczania wysokości dodatku za popłudniową

zmianę czyli Travel Allowance. 

Widok  Rate of Allowance wyświetla 2 informacje :

1.liczba dni na popołudniową zmianę/ PM danego miesiąca 

2.wysokość dodatku do popołudniowych zmian/Travel Allowance w danym miesiącu

  
Wprowadzanie danych na stronie Preferences
>Select Date: po kliknięciu na ten box pokazuje się kalendarz z nieaktywnym bieżącym miesiącem.
>Należy kliknąć na strzałkę w górnym, prawym rogu, żeby przejsć do kolejnego miesiąca.
>Aktywne są tylko kolejne miesiące, ponieważ aplikacja służy do wpisywania preferencji użytkownika 
>Użytkownik wybiera dni, w których chce pracować danego miesiąca. Praca odbywa się w systemie 24/7.
>Użytkownik każdego miesiąca może zaznaczyć tylko określoną liczbę dni. Informacja, ile dni jest wymaganych
> w danym miesiącu zajduje sie w tabeli Months w bazie danych.
>Zaznaczanie preferencji:
>1. po wyswietleniu kalendarza z następnym miesiącem,użytkownik zaznacza wybrany dzień
>2. następnie w Select Shift wybiera zmianę ranną, czyli AM lub popołudniową PM
>3. następnie w Enter Your Index wpisuje numer, pod którym widnieje w bazie danych.
>   Każdy użytkownik posiada unikatowy numer w bazie danych, zwany indeksem/Index.
>   Wymagane jest , żeby użytkownik znał swój numer/Index w bazie danych.
>   Obecnie w bazie danych jest 3 użytkowników z numerami/Indexami 111, 112, 113.
>   Oznacza to , że po wybraniu dnia i zmiany, należy wprowadzić jeden z 3 powyższych numerów/ Index,
>   aby zapisać Preferencje w bazie danych.
>
>   
>   
>5. 
>Aplikacja informuje użytkownika, czy wprowadził właściwą liczbę dni. 
>Użytkownik jest identyfikowany za pomocą indeksu. Obecnie dostępne indeksy w bazie danych to 111, 112, 113.
>Po wprowadzeniu indeksu, użytkownik zapisuje swoje preferencje do bazy danych. 
  
3.Strona: Rate of Allowance 
>Użytkownik wpisuje swój index i wybiera miesiąc.
>Po przyciśnięciu: Calculate, aplikacja wyświetla informacje o wysokości dodatku travel allowance za wybrany miesiąc.
>Użytkownik otrzymuje również informację o ilości zmian PM/popołudniowych w danym miesiącu, które są podstawą do wyliczania travel allowance. 


Zainicjalizowane dane wyjściowe
1. uzupełniona tabela Months: 12 miesięcy + liczba dni pracujących dla każdego miesiąca


![image](https://github.com/Kalina7911/travel-allowance/assets/115398298/cb02ed1f-ce4c-4452-a5a3-e6afd4e6a9a2)

2. tabela Users uzupełniona 3 użytkownikami z indeksami 111, 112, 113

![image](https://github.com/Kalina7911/travel-allowance/assets/115398298/84f980bf-660b-417d-a85d-e411bb652046)




#### Stos technologiczny:
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

## Uruchownienie 
Proszę przejść na link https://travel-allowance.up.railway.app/


