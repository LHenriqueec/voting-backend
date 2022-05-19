package com.example.voting.transformer.session;

import java.util.List;
import java.util.Optional;

import com.example.voting.dto.session.detail.DetailSessionDTO;
import com.example.voting.dto.session.detail.DetailUserDTO;
import com.example.voting.model.Session;
import com.example.voting.model.User;
import com.example.voting.model.Vote;

public class DetailSessionTransformer {

	public static DetailSessionDTO transform(Session session) {
		DetailSessionDTO detailSession = new DetailSessionDTO();
		detailSession.setId(session.getId());
		detailSession.setDuration(session.getDuration());
		detailSession.setStartedAt(session.getStartedAt());
		detailSession.setEndedAt(session.getEndedAt());
		detailSession.setUsers(transformUsers(session.getUsers(), session.getVotes()));

		return detailSession;
	}

	private static List<DetailUserDTO> transformUsers(List<User> users, List<Vote> votes) {
		return users.stream().map(user -> {
			DetailUserDTO detailUser = new DetailUserDTO();
			detailUser.setCpf(user.getCpf());
			detailUser.setName(user.getName());
			detailUser.setId(user.getId());
			detailUser.setVote(transformVote(user, votes));
			return detailUser;
		}).toList();
	}

	private static String transformVote(User user, List<Vote> votes) {
		Optional<Vote> optional = votes.stream().filter(vote -> vote.getUser().equals(user)).findFirst();
		return optional.orElse(new Vote()).getValue();
	}
}
