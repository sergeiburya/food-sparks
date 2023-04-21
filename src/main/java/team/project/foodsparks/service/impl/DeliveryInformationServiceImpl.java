package team.project.foodsparks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.DeliveryInformation;
import team.project.foodsparks.repository.DeliveryInformationRepository;
import team.project.foodsparks.service.DeliveryInformationService;

@Service
public class DeliveryInformationServiceImpl implements DeliveryInformationService {
    private final DeliveryInformationRepository deliveryInformationRepository;

    @Autowired
    public DeliveryInformationServiceImpl(DeliveryInformationRepository
                                                      deliveryInformationRepository) {
        this.deliveryInformationRepository = deliveryInformationRepository;
    }

    @Override
    public DeliveryInformation add(DeliveryInformation deliveryInformation) {
        return deliveryInformationRepository.save(deliveryInformation);
    }
}
