package com.sibftie.service;

import com.sibftie.model.Proposal;

import java.util.List;

public interface ProposalService {

	public void addProposal(Proposal p);
    public void updateProposal(Proposal p);
    public List<Proposal> getAllProposal();
    public Proposal getProposalById(long id);
    void hapus(long id);
}




