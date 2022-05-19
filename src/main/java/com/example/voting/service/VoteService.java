package com.example.voting.service;

import com.example.voting.dto.vote.VoteSessionDTO;
import com.example.voting.model.Vote;
import com.example.voting.repository.VoteRepository;
import com.example.voting.transformer.vote.RegisterVoteTransformer;

@org.springframework.stereotype.Service
public class VoteService extends Service<Vote, VoteRepository> {

	public int registerVote(VoteSessionDTO voteDTO) {
		Vote vote = RegisterVoteTransformer.transform(voteDTO);
		return save(vote);
	}
}
