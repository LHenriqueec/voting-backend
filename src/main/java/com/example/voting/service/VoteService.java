package com.example.voting.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.voting.dto.vote.VoteSessionDTO;
import com.example.voting.exception.AgendaInativeException;
import com.example.voting.exception.VoteAlreadyExistsException;
import com.example.voting.model.Vote;
import com.example.voting.repository.VoteRepository;
import com.example.voting.transformer.vote.RegisterVoteTransformer;

@org.springframework.stereotype.Service
public class VoteService extends Service<Vote, VoteRepository> {

	@Autowired
	private SessionService sessionService;

	public int registerVote(VoteSessionDTO voteDTO) throws VoteAlreadyExistsException {
		Vote vote = RegisterVoteTransformer.transform(voteDTO);

		if (repository.existsByUserAndSession(vote.getUser(), vote.getSession()))
			throw new VoteAlreadyExistsException("vote alredy exist");

		if (sessionService.sessionIsActive(vote.getSession()))
			return save(vote);
		else
			throw new AgendaInativeException("agenda inative");
	}
}
