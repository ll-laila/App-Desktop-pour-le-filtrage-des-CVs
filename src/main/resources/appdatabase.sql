-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 13 déc. 2023 à 22:24
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `appdatabase`
--

-- --------------------------------------------------------

--
-- Structure de la table `condidat`
--

CREATE TABLE `condidat` (
  `id_condidat` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `cv` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `id_cv` int(11) DEFAULT NULL,
  `randomvalue` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `condidat`
--

INSERT INTO `condidat` (`id_condidat`, `nom`, `prenom`, `telephone`, `cv`, `email`, `login`, `password`, `id_cv`, `randomvalue`) VALUES
(3, '', '', '', '', '', 'ou', 'ou', NULL, 0),
(4, 'y', 'g', 'g', '', 'g', 'g', 'gggggggg', NULL, 0),
(5, 'n', 'n', 'n', '', 'n', 'n', '$2a$10$Q6zjd0eJSG3pRcVPUu5jYu1XNrie2XDGm/fH33jwB6/y0PbFBwO5O', NULL, 0),
(6, 'u', 'uu', 'u', '', 'u', 'u', '998a364b79915f8c78d2646f885217ef1b0e30994d2e376439ec0741b366e331', NULL, 0),
(7, 'k', 'k', 'k', '', 'k', 'k', 'fa0422d5025ecfa96b9f58a222dc7422f2bdfa184e0880954e28563974e393a6', NULL, 0),
(8, 'h', 'h', 'h', '', 'h', 'h', '1c6cba22062f73086c323485b19fd859e0136b0889cb3bbaef061f0f85111edf', NULL, 0),
(9, 'g', 'g', 'g', '', 'gg', 'g', 'd5fe46b1204cb7bb339b929b1777e04d2c7235915d7a50d6baa134e20dbc80c6', NULL, 397),
(10, '', '', '', 'Professional CV Resume-1.pdf', '', '', '', NULL, 0),
(11, 't', 't', 't', '', 't', 'p', '5208dce8de0fed86f96119e8259e7f99b9fdda607810db3c54e36aa6ac163469', NULL, 542),
(12, 'r', 'rrr', 'r', '', 'r', 'r', 'rrrrrrrr', NULL, 590),
(13, 'a', 'a', 'a', '', 'aa', 'a', '1f3ce40415a2081fa3eee75fc39fff8e56c22270d1a978a7249b592dcebd20b4', NULL, 271);

-- --------------------------------------------------------

--
-- Structure de la table `condidateur`
--

CREATE TABLE `condidateur` (
  `id_condidateur` int(255) NOT NULL,
  `id_offre` int(255) NOT NULL,
  `id_condidat` int(255) NOT NULL,
  `compétences` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `condidateur`
--

INSERT INTO `condidateur` (`id_condidateur`, `id_offre`, `id_condidat`, `compétences`) VALUES
(1, 12, 271, '[PHP, Python, DJANGO]'),
(2, 6, 271, '[]'),
(3, 7, 271, '[]');

-- --------------------------------------------------------

--
-- Structure de la table `cv`
--

CREATE TABLE `cv` (
  `id_cv` int(11) NOT NULL,
  `formation` text NOT NULL,
  `experiences` text NOT NULL,
  `projects` text NOT NULL,
  `certifications` text NOT NULL,
  `competences` text NOT NULL,
  `langues` text NOT NULL,
  `interets` text NOT NULL,
  `pdf_data` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

CREATE TABLE `offre` (
  `id_offre` int(11) NOT NULL,
  `intitule_p` varchar(255) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `salaire` double NOT NULL,
  `description_poste` text NOT NULL,
  `dateLancement` date NOT NULL,
  `dateExpiration` date NOT NULL,
  `id_recruteur` int(11) DEFAULT NULL,
  `randomvalue` int(255) NOT NULL,
  `critères` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `offre`
--

INSERT INTO `offre` (`id_offre`, `intitule_p`, `ville`, `type`, `salaire`, `description_poste`, `dateLancement`, `dateExpiration`, `id_recruteur`, `randomvalue`, `critères`) VALUES
(2, 't', 't', 't', 657565, 'HFGFGGR', '2023-11-30', '2023-12-15', NULL, 0, ''),
(3, 'o', 'b', 'b', 3454, 'HH', '2023-11-29', '2023-11-30', NULL, 383, ''),
(4, 'stage', 'fes', 'fes', 544554, 'HGHHHHG', '2023-12-07', '2023-12-02', NULL, 383, ''),
(5, 'stage', 'tanger', 'tanger', 544554, 'HGHHHHG', '2023-12-07', '2023-12-02', NULL, 383, 'PHP  Bootsrap  Python Symfon'),
(6, 'stage', 'marrakech', 'marrakech', 544554, 'HGHHHHG', '2023-12-07', '2023-12-02', NULL, 383, ''),
(7, 'web developper', 'marrakech', 'marrakech', 544554, 'HGHHHHG', '2023-12-07', '2023-12-02', NULL, 383, ''),
(8, 'ingenieur', 'marrakech', 'marrakech', 544554, 'HGHHHHG', '2023-12-07', '2023-12-02', NULL, 383, ''),
(9, 'pfe', 'jhjhjhj', 'jhjhjhj', 543453, 'HHHH', '2023-12-02', '2023-12-08', NULL, 383, ''),
(10, 'oo', 'ijj', 'ijj', 87787, 'JHJ', '2023-12-07', '2023-12-09', NULL, 383, ''),
(11, 'oo', 'ijj', 'ijj', 87787, 'JHJ', '2023-12-07', '2023-12-09', NULL, 383, ''),
(12, 'Web developper', 'Casa', 'Casa', 20000, 'gghg gygygg gygyg', '2023-12-13', '2023-12-15', NULL, 383, 'PHP Python Git CSS DJANGO');

-- --------------------------------------------------------

--
-- Structure de la table `recruteur`
--

CREATE TABLE `recruteur` (
  `id_recr` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `nom_Entr` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `randomvalue` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `recruteur`
--

INSERT INTO `recruteur` (`id_recr`, `nom`, `prenom`, `nom_Entr`, `tel`, `adresse`, `email`, `login`, `password`, `randomvalue`) VALUES
(16, 't', 't', '', 't', '', 't', 'o', '5208dce8de0fed86f96119e8259e7f99b9fdda607810db3c54e36aa6ac163469', 383);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `condidat`
--
ALTER TABLE `condidat`
  ADD PRIMARY KEY (`id_condidat`),
  ADD KEY `id_cv` (`id_cv`);

--
-- Index pour la table `condidateur`
--
ALTER TABLE `condidateur`
  ADD PRIMARY KEY (`id_condidateur`);

--
-- Index pour la table `cv`
--
ALTER TABLE `cv`
  ADD PRIMARY KEY (`id_cv`);

--
-- Index pour la table `offre`
--
ALTER TABLE `offre`
  ADD PRIMARY KEY (`id_offre`),
  ADD KEY `fk_offre_recruteur` (`id_recruteur`);

--
-- Index pour la table `recruteur`
--
ALTER TABLE `recruteur`
  ADD PRIMARY KEY (`id_recr`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `condidat`
--
ALTER TABLE `condidat`
  MODIFY `id_condidat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `condidateur`
--
ALTER TABLE `condidateur`
  MODIFY `id_condidateur` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `cv`
--
ALTER TABLE `cv`
  MODIFY `id_cv` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `offre`
--
ALTER TABLE `offre`
  MODIFY `id_offre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `recruteur`
--
ALTER TABLE `recruteur`
  MODIFY `id_recr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `condidat`
--
ALTER TABLE `condidat`
  ADD CONSTRAINT `id_cv` FOREIGN KEY (`id_cv`) REFERENCES `cv` (`id_cv`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `offre`
--
ALTER TABLE `offre`
  ADD CONSTRAINT `fk_offre_recruteur` FOREIGN KEY (`id_recruteur`) REFERENCES `recruteur` (`id_recr`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
