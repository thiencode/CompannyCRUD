package com.example.companydemo.model.base;

import com.unicloud.repository.UUIDEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
public abstract class BaseModel extends UUIDEntity {
}
