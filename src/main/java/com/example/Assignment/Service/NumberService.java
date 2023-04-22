package com.example.Assignment.Service;

import com.example.Assignment.Dto.FetchResponseDto;
import com.example.Assignment.Dto.NumberRequestDto;
import com.example.Assignment.Model.NumberEntity;
import com.example.Assignment.Repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NumberService {
    @Autowired
    NumberRepository numberRepository;

    public String EnterNumber(NumberRequestDto numberDto)
    {
        NumberEntity xNumber = NumberEntity.builder().
                number(numberDto.getNumber())
                .build();

        try {
            numberRepository.save(xNumber);
        }catch (Exception e)
        {
            return "Number is not saved";
        }
        return "number save successfully";
    }

    public FetchResponseDto fetchNextNumber(int id)
    {
         NumberEntity num = numberRepository.findById(id).get();
         int old_value = num.getNumber();

         int new_number = 0;

         boolean flag = false;
         int tempNum = old_value;
         while (!flag)
         {
             tempNum++;
             int sum = findSum(tempNum);
             if(sum == 1)
             {
                 new_number = sum;
                 break;
             }
         }
         numberRepository.updateNumber(num,new_number);

         FetchResponseDto responseDto = new FetchResponseDto();
         responseDto.setOldNum(old_value);
         responseDto.setNewNum(new_number);

         return responseDto;

    }
    public int findSum(int number)
    {
        if (number < 9) return number;

        int sum = 0;

        while (number != 0)
        {
            sum = sum + number % 10;

            number = number/10;

            System.out.println(sum+" "+ number);
        }

        return findSum(sum);
    }
}
