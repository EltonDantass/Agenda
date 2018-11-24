import android.content.ContentValues;

public class Contato {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getPromocoes() {
        return promocoes;
    }

    public void setPromocoes(Integer promocoes) {
        this.promocoes = promocoes;
    }

    String nome, email, telefone, nascimento,sexo;
    Integer promocoes;


    public ContentValues getContentValues(){
        ContentValues cv = new ContentValues();
        cv.put("nome",this.nome);
        cv.put("email", this.email);
        cv.put("telefone", this.telefone);
        cv.put("nascimento", this.nascimento);
        cv.put("sexo", this.sexo);
        cv.put("promocoes", this.promocoes);
        return cv;
    }
}
