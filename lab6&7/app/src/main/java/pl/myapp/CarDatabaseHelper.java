package pl.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class CarDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "cars"; // Nazwa bazy danych
    private static final int DB_VERSION = 1; // Numer wersji bazy danych

    CarDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE CAR (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertCar(db, "Skoda Octavia", "Klasa sama dla siebie", R.drawable.skoda_o);
            insertCar(db, "Skoda Fabia", "Wyprzedź trendy", R.drawable.skoda_f);
        }
        insertCar(db, "Skoda Superb", "Elegancja zawsze i wszędzie", R.drawable.skoda_s);
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE CAR ADD COLUMN FAVORITE NUMERIC;");
        }
    }

    private static void insertCar(SQLiteDatabase db, String name,
                                   String description, int resourceId) {
        ContentValues filmValues = new ContentValues();
        filmValues.put("NAME", name);
        filmValues.put("DESCRIPTION", description);
        filmValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("CAR", null, filmValues);
    }
}
