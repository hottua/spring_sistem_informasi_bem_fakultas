package com.sibftie.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.sibftie.model.Proposal;

public interface ProposalRepository extends JpaRepository<Proposal, Long>
{
	Proposal findProposalById(long id);
}
