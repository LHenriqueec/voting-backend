package com.example.voting.transformer.vote;

import com.example.voting.dto.vote.VoteSessionDTO;
import com.example.voting.model.Session;
import com.example.voting.model.User;
import com.example.voting.model.Vote;

public class RegisterVoteTransformer {

	public static Vote transform(VoteSessionDTO voteDTO) {
		Vote vote = new Vote();
		vote.setValue(voteDTO.getValue());

		Session session = new Session();
		session.setId(voteDTO.getSessionId());
		vote.setSession(session);

		User user = new User();
		user.setId(voteDTO.getUserId());
		vote.setUser(user);

		return vote;
	}
}
