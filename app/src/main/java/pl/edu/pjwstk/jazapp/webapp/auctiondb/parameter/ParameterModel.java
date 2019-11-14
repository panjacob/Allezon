package pl.edu.pjwstk.jazapp.webapp.auctiondb.parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ParameterModel {
    @Inject
    ParameterRequest parameterRequest;
    @Inject
    ParameterRepository parameterRepository;

    public void create(){ parameterRepository.create(parameterRequest.getName()); }

    public void editName() {parameterRepository.editName(parameterRequest.getId(), parameterRequest.getName());}

    public void editId() {parameterRepository.editId(parameterRequest.getId(), parameterRequest.getNewId());}


}
