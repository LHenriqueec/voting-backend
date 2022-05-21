package com.example.voting.transformer.vote;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.voting.model.Vote;

public class DetailVotesTransformer {

	public static Map<String, Long> transform(List<Vote> votes) {
		return votes.stream().collect(Collectors.groupingBy(vote -> vote.getValue(), Collectors.counting()));
	}
}
