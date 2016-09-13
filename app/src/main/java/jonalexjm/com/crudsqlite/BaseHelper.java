package jonalexjm.com.crudsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by andrea on 27/08/2016.
 * En esta clase podemos crear la tablas
 */
public class BaseHelper extends SQLiteOpenHelper {


    String tabla="CREATE TABLE PERSONAS(ID INTEGER PRIMARY KEY, NOMBRE TEXT, APELLIDO TEXT)";
    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override//EN ESTE METODO CREAMOS LA TABLAS
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);// crea la tabla

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table personas");
        db.execSQL(tabla);

    }
}
