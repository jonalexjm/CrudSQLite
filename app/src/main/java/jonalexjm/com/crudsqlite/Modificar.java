package jonalexjm.com.crudsqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Modificar extends AppCompatActivity {

    EditText EdtxtNombre;
    EditText EdtxtApellido;
    Button btnModificar;
    Button btnEliminar;

    int id;
    String nombre;
    String apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        Bundle b = getIntent().getExtras();//con esto recibimos los parametros
        if (b!=null){
            id = b.getInt("Id");
            nombre=b.getString("Nombre");
            apellido=b.getString("Apellido");


        }

        EdtxtNombre = (EditText) findViewById(R.id.EdtxtNombre);
        EdtxtApellido = (EditText) findViewById(R.id.EdtxtApellido);

        EdtxtNombre.setText(nombre);
        EdtxtApellido.setText(apellido);

        btnModificar = (Button) findViewById(R.id.btnModificar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui pasamos los datos a modificar
                Modificar(id,EdtxtNombre.getText().toString(), EdtxtApellido.getText().toString());
                onBackPressed();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Eliminar(id);
                onBackPressed();//regrear al menu
            }
        });
    }

    private void Modificar(int Id, String Nombre, String Apellido){
        BaseHelper helper = new BaseHelper(this, "Demo", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        //si es empresarial hay que hacerle un try catch
        String sql = "update Personas set Nombre='"+ Nombre +"',Apellido='"+ Apellido +"' where Id="+Id;
        db.execSQL(sql);
        db.close();

    }

    private void Eliminar(int Id){
        BaseHelper helper = new BaseHelper(this, "Demo", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        //si es empresarial hay que hacerle un try catch
        String sql = "delete from Personas where Id='"+ Id;
        db.execSQL(sql);
        db.close();

    }
}
