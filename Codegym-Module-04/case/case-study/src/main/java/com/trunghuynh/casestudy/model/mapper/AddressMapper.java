package com.trunghuynh.casestudy.model.mapper;

import com.trunghuynh.casestudy.model.dto.response.AddressResponseDto;
import com.trunghuynh.casestudy.model.entity.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressMapper implements GeneralMapper<Address,AddressResponseDto>{

    @Override
    public AddressResponseDto convert(Address source) {
        AddressResponseDto addressResponseDto = new AddressResponseDto();
        BeanUtils.copyProperties(source, addressResponseDto);
        return addressResponseDto;
    }

    @Override
    public Address revert(AddressResponseDto target) {
        Address address = new Address();
        BeanUtils.copyProperties(target, address);
        return address;
    }

    @Override
    public List<AddressResponseDto> convert(List<Address> sources) {
        return sources.stream().map(this::convert).toList();
    }

    @Override
    public List<Address> revert(List<AddressResponseDto> targets) {
        return targets.stream().map(this::revert).toList();
    }
}
