package edu.br.utpfr.trabalho_pw44s.server.service;

import edu.br.utpfr.trabalho_pw44s.server.model.User;

public interface IUserService extends ICrudService<User, Long>{
    User saveEncrypt(User user);
}
