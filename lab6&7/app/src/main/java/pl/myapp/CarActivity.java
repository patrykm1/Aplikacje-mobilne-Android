package pl.myapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CarActivity extends AppCompatActivity {

    public static final String EXTRA_CARNO = "carNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        int carNo = (Integer) getIntent().getExtras().get(EXTRA_CARNO);
        try {
            SQLiteOpenHelper carDatabaseHelper = new CarDatabaseHelper(this);
            SQLiteDatabase db = carDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("CAR",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID", "FAVORITE"},
                    "_id = ?",
                    new String[]{Integer.toString(carNo)},
                    null, null, null);
            if (cursor.moveToFirst()) {
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);
                boolean isFavorite = (cursor.getInt(3) == 1);

                TextView name = (TextView) findViewById(R.id.name);
                name.setText(nameText);

                TextView description = (TextView) findViewById(R.id.description);
                description.setText(descriptionText);

                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);

                CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
                favorite.setChecked(isFavorite);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database is unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onFavoriteClicked(View view) {
        int carNo = (Integer) getIntent().getExtras().get("carNo");
        new UpdateCarTask().execute(carNo);
        CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
        if (!favorite.isChecked()) {
            Toast toast = Toast.makeText(CarActivity.this, "Car has been removed from favorites", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private class UpdateCarTask extends AsyncTask<Integer, Integer, Boolean> {

        ContentValues carValues;

        protected void onPreExecute() {
            CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
            carValues = new ContentValues();
            carValues.put("FAVORITE", favorite.isChecked());
        }

        protected Boolean doInBackground(Integer... cars) {
            int carNo = cars[0];
            SQLiteOpenHelper carDatabaseHelper = new CarDatabaseHelper(CarActivity.this);
            try {
                SQLiteDatabase db = carDatabaseHelper.getWritableDatabase();
                db.update("CAR", carValues,
                        "_id = ?", new String[]{Integer.toString(carNo)});
                db.close();
                publishProgress(1);
                return true;
            } catch (SQLiteException e) {
                return false;
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Toast toast = Toast.makeText(CarActivity.this, "Car has been added to favorites", Toast.LENGTH_SHORT);
            toast.show();
        }

        protected void onPostExecute(Boolean success) {
            if (!success) {
                Toast toast = Toast.makeText(CarActivity.this,
                        "Database is unavailable", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
