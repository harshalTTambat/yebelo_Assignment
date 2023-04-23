package com.example.Assignment.Service;

import com.example.Assignment.Dto.NumberRequestDto;
import com.example.Assignment.Model.NumberEntity;
import com.example.Assignment.Repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberService {
    @Autowired
    NumberRepository numberRepository;

    public String EnterNumber(NumberRequestDto numberDto)
    {
        int num = numberDto.getNumberChoice();
        int newNum = nextNumGenerator(num);
        NumberEntity xNumber = NumberEntity.builder().
                numberChoice(num).
                newNumber(newNum).build();

        try {
            numberRepository.save(xNumber);
        }catch (Exception e)
        {
            return "Number is not saved";
        }
        return "number save successfully";
    }

    public NumberEntity fetchNextNumber(int id)
    {
         NumberEntity num = numberRepository.findById(id).get();

         int newValue = nextNumGenerator(num.getNewNumber());
         num.setNumberChoice(num.getNewNumber());
         num.setNewNumber(newValue);
         numberRepository.save(num);
         return num;
    }
    public int nextNumGenerator(int old_num)
    {
        int new_number = 0;

        boolean flag = false;

        int sum =0;
        for(int i=old_num+1;i<old_num + 2000;i++)
        {
            if(flag)
            {

                new_number = i-1;
                break;
            }

            sum = findSum(i);

            if(sum == 1)
            {
                flag = true;
            }

        }
        return new_number;
    }

    public int findSum(int n)
    {
        int sum = 0;

        while (n > 0 || sum > 9)
        {
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
