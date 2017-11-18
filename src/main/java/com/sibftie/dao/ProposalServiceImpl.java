package com.sibftie.dao;
import com.sibftie.model.Proposal;
import com.sibftie.repository.ProposalRepository;
import com.sibftie.service.DokumenService;
import com.sibftie.service.ProposalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Service
public class ProposalServiceImpl implements ProposalService{
	@Autowired
    private ProposalRepository proposalRepository;
	
	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
    public void addProposal(Proposal p)
    {
        proposalRepository.save(p);
    }

    @Override
    public void updateProposal(Proposal p)
    {
        Proposal updateProposal = proposalRepository.findProposalById(p.getId());
        updateProposal.setJudulDokumen(p.getJudulDokumen());
        updateProposal.setPathDokument(p.getPathDokument());
        proposalRepository.save(updateProposal);
    }

    @Override
    public List<Proposal> getAllProposal() {
        return proposalRepository.findAll();
    }

    @Override
    public Proposal getProposalById(long id) {
        return proposalRepository.findProposalById(id);
    }

	@Override
	public void hapus(long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Proposal.class, id));
		em.getTransaction().commit();
		
	}
}


