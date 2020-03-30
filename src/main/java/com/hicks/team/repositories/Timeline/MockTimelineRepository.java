package com.hicks.team.repositories.Timeline;

import com.hicks.team.models.Timeline;
import com.hicks.team.repositories.MockDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MockTimelineRepository implements TimelineRepository {

    MockDatabase mockDatabase;

    @Autowired
    public MockTimelineRepository(MockDatabase mockDatabase) {
        this.mockDatabase = mockDatabase;
    }

    @Override
    public Timeline findByUserId(long userId) {
        return mockDatabase.findByUserId(userId);
    }

    @Override
    public List<Timeline> findAll() {
        return null;
    }

    @Override
    public List<Timeline> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<Timeline> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public <S extends Timeline> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Timeline> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Timeline> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Timeline getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Timeline> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Timeline> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<Timeline> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Timeline> S save(S entity) {
        return null;
    }

    @Override
    public Optional<Timeline> findById(Long aLong) {
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
    public void delete(Timeline entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Timeline> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Timeline> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Timeline> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Timeline> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Timeline> boolean exists(Example<S> example) {
        return false;
    }
}
