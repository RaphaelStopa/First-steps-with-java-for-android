package com.example.comovota;

import com.example.comovota.domain.Political;
import com.example.comovota.domain.PoliticalParty;
import com.example.comovota.domain.Project;
import com.example.comovota.domain.Vote;
import com.example.comovota.domain.enumeration.ElectivePositionType;
import com.example.comovota.domain.enumeration.TypeOfVote;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class  Data {


    public ArrayList<Political> database () {
        // simulation for testing - projects
        Set<Project> projects = new HashSet<>();
        Project projectOne = new Project(1l, "44/2021", "Aumento do Fundão Eleitoral.",
                "Aumento do fundo eleitoralde R$ 5,7 bilhões.", true);

        Project projectTwo = new Project(2l, "PL 4199/2020", "BR do Mar.",
                "O BR do Mar busca incentivar a navegação de cabotagem.", true);

        Project projectTree = new Project(3l, "PLS 261/2018", "Marco Legal das Ferrovias.",
                "Autoriza a exploração de serviços de transporte ferroviário pelo setor privado.", false);

        Project projectFour = new Project(4l, "MPV 1085/2021", "Mudança nos Serviços de Cartórios.",
                "Cria o Sistema Eletrônico de Registros Públicos.", false);

        Project projectFive = new Project(5l, "PL 442/1991", "Marco Legal dos Jogos.",
                "Pretende regulamentar a exploração dos seguintes \"jogos de fortuna\": jogos de cassino; jogo de bingo; jogos lotéricos federais e estaduais; apostas de quotas fixas; apostas eletrônicas.", true);

        projects.add(projectOne);
        projects.add(projectTwo);
        projects.add(projectTree);
        projects.add(projectFour);
        projects.add(projectFive);

        // simulation for testing - political party / just one is enough
        PoliticalParty politicalParty = new PoliticalParty(1l, "Partido dos Enroladores Profissionais.",
                "PDRP", false );

        // simulation for testing - vote
        Set<Vote> voteOneList = new HashSet<>();
        Set<Vote> voteTwoList = new HashSet<>();
        Set<Vote> voteTreeList = new HashSet<>();
        Set<Vote> voteFourList = new HashSet<>();
        Set<Vote> voteFiveList = new HashSet<>();


        Vote voteOne = new Vote(TypeOfVote.YES, projectOne);
        Vote voteTwo = new Vote(TypeOfVote.YES, projectTwo);
        Vote voteTree = new Vote(TypeOfVote.YES, projectTree);
        Vote voteFour = new Vote(TypeOfVote.NO, projectOne);
        Vote voteFive = new Vote(TypeOfVote.NO, projectTwo);
        Vote voteSix = new Vote(TypeOfVote.ABSTAINED, projectTree);
        Vote voteSeven = new Vote(TypeOfVote.NO, projectTwo);
        Vote voteEight = new Vote(TypeOfVote.ABSTAINED, projectTree);

        voteOneList.add(voteFour);
        voteOneList.add(voteFive);
        voteOneList.add(voteSix);

        voteTwoList.add(voteOne);
        voteTwoList.add(voteTwo);
        voteTwoList.add(voteTree);

        voteTreeList.add(voteOne);
        voteTreeList.add(voteFive);
        voteTreeList.add(voteSix);

        voteFourList.add(voteEight);
        voteFourList.add(voteSeven);
        voteFourList.add(voteFour);

        voteFiveList.add(voteEight);
        voteFiveList.add(voteSeven);
        voteFiveList.add(voteOne);



        // simulation for testing - political
//        Set<Political> politicals = new HashSet<>();

        ArrayList politicals = new ArrayList();

        Political politicalOne = new Political(1l, "Amarildo Santos",
                ElectivePositionType.SENADOR, politicalParty, voteOneList, false);

        Political politicalTwo = new Political(2l, "Marilda do Povo",
                ElectivePositionType.DEPUTADO_FEDERAL, politicalParty, voteTwoList, false);

        Political politicalTree = new Political(3l, "Andrade Lero",
                ElectivePositionType.DEPUTADO_FEDERAL, politicalParty, voteTreeList, false);

        Political politicalFour = new Political(4l, "Elenice do Capelario",
                ElectivePositionType.DEPUTADO_FEDERAL, politicalParty, voteFourList, false);

        Political politicalFive = new Political(5l, "Raphael Stopa",
                ElectivePositionType.SENADOR, politicalParty, voteFiveList, false);

        politicals.add(politicalOne);
        politicals.add(politicalTwo);
        politicals.add(politicalTree);
        politicals.add(politicalFour);
        politicals.add(politicalFive);


        return politicals;
    }

    public ArrayList<Political> politicalFilterByType(String filter) {
        // parei aqui. Aqui filtar o tipo de poltico. vou usar o intent para isto
        // falta filtar por id

        return database().stream().filter(x -> x.getElectivePositionType()
                .toString().equals(filter.toUpperCase()))
                .filter(x -> x.isDeleted() == false)
                .sorted(Comparator.comparing(o -> o.getName()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Political politicalFilterById (String filter) throws Exception {
        long id = Long.parseLong(filter);
        return database().stream().filter(x -> x.getId() == id).findFirst().orElseThrow(Exception::new);
    }

}
