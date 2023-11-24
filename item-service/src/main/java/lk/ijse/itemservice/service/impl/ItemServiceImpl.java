package lk.ijse.itemservice.service.impl;

import lk.ijse.itemservice.dto.ItemDTO;
import lk.ijse.itemservice.repo.ItemRepo;
import lk.ijse.itemservice.service.ItemService;
import lk.ijse.itemservice.util.DataTypeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private DataTypeConversion dataTypeConversion;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public ItemDTO saveItem(ItemDTO item) {
        return dataTypeConversion.getItemDTO(itemRepo.save(dataTypeConversion.getItemEntity(item)));
    }
}
