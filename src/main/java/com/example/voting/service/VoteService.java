package com.example.voting.service;

import com.example.voting.dto.vote.VoteSessionDTO;
import com.example.voting.exception.VoteAlreadyExistsException;
import com.example.voting.model.Vote;
import com.example.voting.repository.VoteRepository;
import com.example.voting.transformer.vote.RegisterVoteTransformer;

@org.springframework.stereotype.Service
public class VoteService extends Service<Vote, VoteRepository> {

	public int registerVote(VoteSessionDTO voteDTO) throws VoteAlreadyExistsException {
		Vote vote = RegisterVoteTransformer.transform(voteDTO);
		if (repository.existsByUserAndSession(vote.getUser(), vote.getSession()))
			throw new VoteAlreadyExistsException("vote alredy exist");
		return save(vote);
	}
}
