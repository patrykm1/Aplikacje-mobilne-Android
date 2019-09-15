# Aplikacje-mobilne-Android
##LAB3:
Klasa: MainActivity
	Klasa obsługująca główną aktywność. W układzie tej klasy znajdują się wszystkie elementy wymienione w zadaniu: switch, radio, checkbox, spinner, textview itd. W tej klasie znajdują się również metody do obsługi zdarzeń tych elementów:
Metody:
	onSwitchClicked(View view) - jako parametr przyjmuje obiekt klasy View (reprezentuje ona podstawowe komponenty interfejsu dla uzytkownika). Metoda ta wykrywa, czy stan elementu Switch został zmieniony. W zależności od stanu, wartość pola textview jest zmieniana.
	onCheckboxClicked(View view) - zasada działania jest bardzo podobna jak w w/w. metodzie. W zależności, który checkbox jest "aktywny", wyświetlany jest komunikat za pomocą metody makeText(this,text,duration) wywołanej na obiekcie klasy Toast. Ta metoda jako parametry przyjmuje tekst, który ma zostać wyświetlony oraz czas trwania wyświetlania komunikatu.
	onRadioButtonClicked(View view) - schemat działania jest taki jak wyżej. Elementy RadioButton grupowane są przy użyciu RadioGroup. Dzięki temu, tylko jeden element z danej grupy może być wybrany. W zależności, który element zostanie wybrany, za pomocą klasy Toast zostanie wyświetlony odpowiedni komunikat.
	onButtonClicked(View view) - metoda, która wykrywa kliknięcie na obrazku. Jeżeli tak się stanie, zostanie uruchomiona nowa aktywność (SecondActivity).
Klasa: SecondActivity
	Klasa, której aktywność zostaje wywołana poprzez klasę MainActivity.
Metody:
	onCreate(Bundle savedInstanceState) - metoda uruchomieniowa do której dodajemy widok naszego układu (a w nim szczegółowe informacje)
 
###LAB4:
Klasa: MainActivity
	Klasa obsługująca główną aktywność. W układzie tej klasy znajduję się element ListView, który wyświetla informacje w postaci listy oraz obsługuję zdarzenia związane z tymi informacjami, oraz został również dodany pasek narzędzi na którym znajduję się Menu które udostępnia nam możliwość podejrzenia informacji na temat aplikacji.
Metody: 
	onItemClick() - jest to metoda nadpisana przez klasę AdapterView z której korzystamy do utworzenia obiektu nasłuchującego(reagującego na klikniecie elementu widoku). Po kliknięciu na element listy zostajemy przekierowani do następnego układu przypisanego do tego elementu.
	onCreateOptionsMenu() - metoda uruchomieniowa obsługująca układ Manu znajdującego się na pasku narzędzi.
	onOptionsItemSelected() - metoda obsługująca kliknięcie elementu w naszym Menu, w rezultacie czego zostaje włączony osobny układu z informacjami na temat aplikacji.
Klasa:SkodaAktivity
	Klasa obsługująca aktywność drugo poziomową w której również znajduję się ListView.
Metody:
	onItemClick() - zasada działania jest taka sama jak w klasie MainActivity.
Klasa:FabiaActivity, FeliciaActivity, OctaviaActivity
	Klasy obsługujące aktywności trzeciego poziomu, w układach tych klas znajdują się informacje dotyczące poszczególnych samochodów.
 
####LAB5:
Klasa: MainActivity
	Klasa obsługująca główną aktywność. W momencie uruchomienia, wywoływany jest główny układ aktywności, który zawiera poszczególne fragmenty.
Metody:
	onCreate() - metoda uruchomieniowa. W niej ustawiany jest układ aktywności.
	itemClicked(int id) - metoda, która wykrywa kliknięty fragment. Następnie tworzony jest obiekt klasy TypeDetailFragment, który wykorzystany jest do rozpoczęcia transakcji za pomocą klasy FragmentTransaction.
Klasa: StopwatchFragment
	Klasa wykorzystująca aktywność do wyświetlania stoperu.
Metody:
	onCreate() - metoda uruchomieniowa. Dodatkowo zawiera flagi sprawdzające, czy stoper jest lub był uruchomiony.
	onCreateView() - metoda, która w zależności od klikniętego przycisku (który wykrywany jest w metodzie onClick()), uruchamia odpowiednią metodę (onClickStart,onClickStop,onClickReset))
	runTimer() - metoda służąca do wyświetlania czasu oraz do cyklicznego zwiększania go.
Klasa: Type
	Klasa opisująca nasze fragmenty. Zawiera pola, stała tablicę, konstruktor oraz getter i setter do pól.
Klasa: TypeDetailFragment
	Dzięki tej klasie, wyświetlane są informacje utworzone w klasie Type.
Metody:
	onCreateView() - w tej metodzie, w jednym fragmencie umieszczamy drugi fragment (stoper).
 
#####LAB6/7:
Klasa: CarDatabaseHelper
	Klasa rozszerzającą SQLiteOpenHelper, służąca do obsługi bazy danych.
Metody:
	onCreate() - metoda wywoływana w momencie, gdy baza tworzona jest po raz pierwszy na urządzeniu.
	onUpgrade() - wywoływana w momencie, gdy trzeba zaktualizować bazę danych.
	updateMyDatabase() - metoda, która sprawdza obecną wersję bazy danych. Jeżeli wersja jest mniejsza od 1 (czyli w ogólnie nie istnieje), to struktura bazy danych jest tworzona. W przeciwnym razie, struktura bazy danych jest upgradeowana. 
	insertCar() - metoda, która umożliwia dodawanie elementów do bazy.
Klasa: CarActivity
	Klasa służąca do pobierania szczegółowych elementów bazy danych.
Metody: 
	onCreate() - pobiera identyfikator wybranego elementu a następnie jego szczegółowe informacje. Metoda udostępnia również możliwość dodania elementu do ulubionych.
	onFavoriteClicked() - po kliknięciu na element, który znajduje się w sekcji ulubione, przenosi nas do wybranego elementu.
	onPreExecute() - klasa służąca do wprowadzenia asynchroniczności. Tutaj umieszczane są elementy, które mają wykonać się przed rozpoczęciem zadania. Aby móc korzystać z asynchroniczności, należy posłużyć się klasąAsyncTask<>.
	doInBackground() - w tej metodzie umieszczony jest kod, który ma się wykonywać w tle.
	onProgressUpdate() - metoda sprawdzająca progres wykonywanych prac
	onPostExecute() - kod, który ma zostać wykonany po zakończeniu zadania
Klasa: TopLevelActivity
	Klasa służąca do wyświetlania elementów, które zostały dodane do sekcji ulubione. W momencie, gdy zostanie kliknięty element, zostanie uruchomiona aktywność CarActivity.




	
	

