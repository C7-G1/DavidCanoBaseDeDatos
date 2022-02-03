package david.cano.davidcanobasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CrearBD crearBD= new CrearBD(this);
        /*SQLiteDatabase bd= crearBD.getWritableDatabase();
        bd.execSQL("UPDATE articulos SET nombre='papel charol' WHERE ref=1");
        bd.execSQL("UPDATE articulos SET nombre='cinta adhesiva' WHERE nombre='carpeta'");
        //Borrado de una fila.
        bd.execSQL(("DELETE FROM articulos WHERE nombre='lapiz'"));

        /*bd.execSQL("INSERT INTO articulos VALUES(1,'papel');");
        bd.execSQL("INSERT INTO articulos VALUES(2,'lapiz');");
        bd.execSQL("INSERT INTO articulos VALUES(3,'carpeta');");
        bd.execSQL("INSERT INTO articulos VALUES(4,'boligrafo');");
        bd.close();*/
        SQLiteDatabase bd = crearBD.getReadableDatabase();
        TextView tv=(TextView) findViewById(R.id.textView);
        Cursor contenido =bd.rawQuery(" Select * from articulos",null);
        while(contenido.moveToNext()){
            tv.append("\n"+contenido.getString(1));
        }
        bd.close();
    }

}