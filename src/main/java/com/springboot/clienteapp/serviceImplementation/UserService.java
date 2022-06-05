package com.springboot.clienteapp.serviceImplementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Perfil;
import com.springboot.clienteapp.models.entity.Usuario;
import com.springboot.clienteapp.models.service.IUsuarioService;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private IUsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.findByCorreo(username);
		
		return buildUser(usuario, buildGrantedAuthorities(usuario.getPerfil()));
	}
	
	private User buildUser(Usuario usuario, List<GrantedAuthority> roles) {
		return new User(usuario.getCorreo(), usuario.getPassword(), !usuario.isBaja(),
					true, true, true, roles);
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(Perfil perfil) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority(perfil.getNombrePerfil()));
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}
}
