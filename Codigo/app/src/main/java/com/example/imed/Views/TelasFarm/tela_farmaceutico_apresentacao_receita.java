package com.example.imed.Views.TelasFarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.MVP.MVPFarmaceutico;
import com.example.imed.Presenters.Farmaceutico.FarmaceuticoApresentacaoReceitaPresenter;
import com.example.imed.R;

public class tela_farmaceutico_apresentacao_receita extends AppCompatActivity implements MVPFarmaceutico.IViewFarmaceuticoToast,
        MVPFarmaceutico.IViewFarmaceuticoApresentarReceita{

    private ImageButton retornarButton;
    private TextView cpfPacienteTextView;
    private TextView medicamentoTextView;
    private TextView dosagemTextView;
    private TextView frequenciaTextView;
    private String valor, receita;
    private FarmaceuticoApresentacaoReceitaPresenter presenter;
    private MVPFarmaceutico.IViewFarmaceuticoApresentarReceita view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_apresentacao_receita);

        Intent intent = getIntent();
        receita = intent.getStringExtra("receita");
        valor = intent.getStringExtra("FarmCrf");

        this.view = this;
        configurarTextView();
        retornar();

        presenter = new FarmaceuticoApresentacaoReceitaPresenter(getApplicationContext(), receita, view);
        presenter.obterReceita();


    }

    public void retornar(){
        retornarButton = findViewById(R.id.farmaceutico_receita_retornar_button);
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_apresentacao_receita.this, tela_farmaceutico_checar_receita.class);
                intent.putExtra("FarmCrf", valor);//Envia o dado de qual farmacêutico está logado
                startActivity(intent);
            }
        });
    }

    public void configurarTextView(){
        cpfPacienteTextView = findViewById(R.id.farmaceutico_receita_cpf_paciente_textview);
        cpfPacienteTextView.setEnabled(false);
        medicamentoTextView = findViewById(R.id.farmaceutico_receita_medicamento_textfield);
        medicamentoTextView.setEnabled(false);
        dosagemTextView = findViewById(R.id.farmaceutico_receita_dosagem_textview);
        dosagemTextView.setEnabled(false);
        frequenciaTextView = findViewById(R.id.farmaceutico_receita_frequencia_textview);
        frequenciaTextView.setEnabled(false);
    }

    @Override
    public void showToast(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarReceita(String cpfPaciente, String medicamento, String dosagem, String frequencia) {

        cpfPacienteTextView.setText(cpfPaciente);
        medicamentoTextView.setText(medicamento);
        dosagemTextView.setText(dosagem);
        frequenciaTextView.setText(frequencia);

    }
}