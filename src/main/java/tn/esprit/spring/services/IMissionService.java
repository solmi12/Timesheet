package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Mission;

public interface IMissionService {

	void deleteMission(String id);

	Mission addMission(Mission m);

	Mission retrieveMission(String id);

	Mission updateMission(Mission m);

	List<Mission> retrieveAllMissions();

}
