package jonalexjm.com.crudsqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText EdtxtNombre;
    EditText EdtxtApellido;
    Button btnGuardar;
    Button btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdtxtNombre = (EditText) findViewById(R.id.EdtxtNombre);
        EdtxtApellido = (EditText) findViewById(R.id.EdtxtApellido);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar(EdtxtNombre.getText().toString(), EdtxtApellido.getText().toString());
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Listado.class));
            }
        });
    }







    private  void guardar(String Nombre, String Apellido){
        BaseHelper helper = new BaseHelper(this, "Demo", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();

        try{
            ContentValues c = new ContentValues();
            c.put("Nombre", Nombre);
            c.put("Apellido",Apellido);
            db.insert("PERSONAS",null, c);
            db.close();
            Toast.makeText(this, "Registro insertado", Toast.LENGTH_SHORT).show();
            EdtxtNombre.setText("");
            EdtxtApellido.setText("");



        }catch (Exception e){
            Toast.makeText(this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
