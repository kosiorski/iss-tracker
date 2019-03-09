package pl.kosiorski.isstracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kosiorski.isstracker.model.IssData;
import pl.kosiorski.isstracker.repository.IssDataRepository;
import pl.kosiorski.isstracker.service.IssDataService;

@Service
public class IssDataServiceImpl implements IssDataService {

  private final IssDataRepository issDataRepository;

  @Autowired
  public IssDataServiceImpl(IssDataRepository issDataRepository) {
    this.issDataRepository = issDataRepository;
  }

  @Override
  public void save(IssData issData) {
    issDataRepository.save(issData);
  }
}
