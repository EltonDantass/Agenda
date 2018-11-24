import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DataBase extends SQLiteOpenHelper {

        private static final String NOME_BANCO = "contatos.db";
        private static final int VERSAO_BANCO = 1;
        private Context context;
        private SQLiteDatabase dbInstancia = null;
        DataBase(Context context){
            super(context,NOME_BANCO,null,VERSAO_BANCO);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE contatos(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " nome TEXT NOT NULL, email TEXT, telefone TEXT, nascimento TEXT, sexo TEXT, promocoes INTEGER)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        public void abrirDB() throws SQLException {
            if(this.dbInstancia == null){
                this.dbInstancia = this.getWritableDatabase();
            }
        }

        public void fecharDB() throws SQLException {
            if(this.dbInstancia != null){
                if(this.dbInstancia.isOpen()){
                    this.dbInstancia.close();
                }
            }
        }

        public void salvarContato(Contato contato) throws SQLException{
            abrirDB();
            dbInstancia.insert("contatos",null,contato.getContentValues());
            Toast.makeText(context,contato.getNome()+"cadastrado",Toast.LENGTH_LONG).show();
            fecharDB();
        }


/*
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contatos");
        onCreate(db);
    } */
    }

