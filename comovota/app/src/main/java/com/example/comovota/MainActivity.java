package com.example.comovota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.comovota.domain.Political;
import com.example.comovota.domain.PoliticalParty;
import com.example.comovota.domain.Project;
import com.example.comovota.domain.Vote;
import com.example.comovota.domain.enumeration.ElectivePositionType;
import com.example.comovota.domain.enumeration.TypeOfVote;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // simulation for testing - projects
      Set<Project> projects = new HashSet<>();
        Project projectOne = new Project(1l, "44/2021", "Aumento do Fundão Eleitoral",
                "aumento do fundo eleitoralde R$ 5,7 bilhões.", true);

        Project projectTwo = new Project(2l, "PL 4199/2020", "BR do Mar",
                "cria o BR do Mar busca incentivar a navegação de cabotagem.", true);

        Project projectTree = new Project(3l, "PLS 261/2018", "Marco Legal das Ferrovias",
                "Autoriza a exploração de serviços de transporte ferroviário pelo setor privado.", false);

        projects.add(projectOne);
        projects.add(projectTwo);
        projects.add(projectTree);

        // simulation for testing - political party / just one is enough
        PoliticalParty politicalParty = new PoliticalParty(1l, "Partido dos Enroladores Profissionais.",
                "PDRP", false );

        // simulation for testing - vote
        Set<Vote> voteOneList = new HashSet<>();
        Set<Vote> voteTwoList = new HashSet<>();
        Set<Vote> voteTreeList = new HashSet<>();

        Vote voteOne = new Vote(TypeOfVote.YES, projectOne);
        Vote voteTwo = new Vote(TypeOfVote.YES, projectTwo);
        Vote voteTree = new Vote(TypeOfVote.YES, projectTree);
        Vote voteFour = new Vote(TypeOfVote.NO, projectOne);
        Vote voteFive = new Vote(TypeOfVote.NO, projectTwo);
        Vote voteSix = new Vote(TypeOfVote.ABSTAINED, projectTree);

        voteOneList.add(voteFour);
        voteOneList.add(voteFive);
        voteOneList.add(voteSix);

        voteTwoList.add(voteOne);
        voteTwoList.add(voteTwo);
        voteTwoList.add(voteTree);

        voteTreeList.add(voteOne);
        voteTreeList.add(voteFive);
        voteTreeList.add(voteSix);


        // simulation for testing - political
        Set<Political> politicals = new HashSet<>();

        Political politicalOne = new Political(1l, "Amarildo Santos",
                ElectivePositionType.SENADOR, politicalParty, voteOneList, false);

        Political politicalTwo = new Political(2l, "Marilda do Povo",
                ElectivePositionType.DEPUTADO_FEDERAL, politicalParty, voteTwoList, false);

        Political politicalTree = new Political(2l, "Andrade Lero",
                ElectivePositionType.DEPUTADO_FEDERAL, politicalParty, voteTreeList, false);



    }

    public void goToSenatorOnClick (View v) {
      Intent intent = new Intent(MainActivity.this, SenatorActivity.class);
      // passe o que quiser usando chave e valor
      intent.putExtra("nha", "nho");
      //
      startActivity(intent);

  }
}