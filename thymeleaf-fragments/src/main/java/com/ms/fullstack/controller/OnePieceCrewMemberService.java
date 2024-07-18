package com.ms.fullstack.controller;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OnePieceCrewMemberService {

	public List<OnePieceCrewMember> findAllCrewMembers(){
		return List.of(
				new OnePieceCrewMember(1,"Luffy","luffy.jpg"),
				new OnePieceCrewMember(2,"Zoro","zoro.jpg"),
				new OnePieceCrewMember(3,"Sanji","sanji.jpg"),
				new OnePieceCrewMember(4,"Nami","nami.jpg"),
				new OnePieceCrewMember(5,"Robin","robin.jpg")
				);
	}
}
