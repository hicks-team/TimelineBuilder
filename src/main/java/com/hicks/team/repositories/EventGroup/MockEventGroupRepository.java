package com.hicks.team.repositories.EventGroup;

import com.hicks.team.models.EventGroup;
import com.hicks.team.repositories.MockDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MockEventGroupRepository implements EventGroupRepository {

    private MockDatabase mockDatabase;

    @Autowired
    public MockEventGroupRepository(MockDatabase mockDatabase) {
        this.mockDatabase = mockDatabase;
    }

    @Override
    public List<EventGroup> findAllByUserId(long userId) {
        return mockDatabase.getEventGroups().stream().filter(x -> x.getUserId() == userId).collect(Collectors.toList());
    }

    @Override
    public List<EventGroup> findAll() {
        return null;
    }

    @Override
    public List<EventGroup> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<EventGroup> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public <S extends EventGroup> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends EventGroup> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<EventGroup> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public EventGroup getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends EventGroup> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends EventGroup> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<EventGroup> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends EventGroup> S save(S entity) {
        return null;
    }

    @Override
    public Optional<EventGroup> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(EventGroup entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends EventGroup> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends EventGroup> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends EventGroup> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends EventGroup> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends EventGroup> boolean exists(Example<S> example) {
        return false;
    }
}
